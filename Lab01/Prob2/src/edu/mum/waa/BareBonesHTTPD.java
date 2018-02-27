package edu.mum.waa;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BareBonesHTTPD extends Thread {

	private static final int PortNumber = 8080;
	private static FrontController frontController = new FrontController();
	Socket connectedClient = null;
	

	public BareBonesHTTPD(Socket client) {
		connectedClient = client;
	}

	public void run() {

		try {
			System.out.println(connectedClient.getInetAddress() + ":" + connectedClient.getPort() + " is connected");

			BBHttpRequest httpRequest = getRequest(connectedClient.getInputStream());

			if (httpRequest != null) {
				BBHttpResponse httpResponse = new BBHttpResponse();

				frontController.processRequest(httpRequest, httpResponse);

				sendResponse(httpResponse);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private BBHttpRequest getRequest(InputStream inputStream) throws IOException {

		BBHttpRequest httpRequest = new BBHttpRequest();

		BufferedReader fromClient = new BufferedReader(new InputStreamReader(inputStream));

		String headerLine = fromClient.readLine();

		if ((headerLine == null)||(headerLine.isEmpty())) {
			return null;
		}

		System.out.println("The HTTP request is ....");
		System.out.println(headerLine);

		// Header Line
		StringTokenizer tokenizer = new StringTokenizer(headerLine);
		httpRequest.setMethod(tokenizer.nextToken());
		httpRequest.setUri(tokenizer.nextToken());
		httpRequest.setHttpVersion(tokenizer.nextToken());

		// Header Fields and Body
		boolean readingBody = false;
		ArrayList<String> fields = new ArrayList<>();
		ArrayList<String> body = new ArrayList<>();

		while (fromClient.ready()) {

			headerLine = fromClient.readLine();
			System.out.println(headerLine);

			if (!headerLine.isEmpty()) {
				if (readingBody) {
					body.add(headerLine);
				} else {
					fields.add(headerLine);
				}
			} else {
				readingBody = true;
			}
		}
		httpRequest.setFields(fields);
		httpRequest.setMessage(body);
		return httpRequest;
	}

	private void sendResponse(BBHttpResponse response) throws IOException {

		String statusLine = null;
		if (response.getStatusCode() == 200) {
			statusLine = "HTTP/1.1 200 OK" + "\r\n";
		} else if (response.getStatusCode() == 404) {
			statusLine = "HTTP/1.1 404 Not Found" + "\r\n";
		} else {
			statusLine = "HTTP/1.1 501 Not Implemented" + "\r\n";
		}

		String serverdetails = "Server: BareBones HTTPServer";
		String contentLengthLine = "Content-Length: " + response.getMessage().length() + "\r\n";
		String contentTypeLine = "Content-Type: " + response.getContentType() + " \r\n";

		try (DataOutputStream toClient = new DataOutputStream(connectedClient.getOutputStream())) {

			toClient.writeBytes(statusLine);
			toClient.writeBytes(serverdetails);
			toClient.writeBytes(contentTypeLine);
			toClient.writeBytes(contentLengthLine);
			toClient.writeBytes("Connection: close\r\n");
			toClient.writeBytes("\r\n");
			toClient.writeBytes(response.getMessage());

		}
	}

	public static void main(String args[]) throws Exception {
		try (ServerSocket server = new ServerSocket(PortNumber, 10, InetAddress.getByName("127.0.0.1"))) {
			System.out.println("Server Started on port " + PortNumber);

			while (true) {
				Socket connected = server.accept();
				(new BareBonesHTTPD(connected)).start();
			}
		}
	}
}
