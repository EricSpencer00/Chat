import { Injectable } from '@angular/core';
import { Client, StompHeaders, IMessage } from '@stomp/stompjs';
import SockJS from 'sockjs-client';

@Injectable({
  providedIn: 'root',
})
export class ChatService {
  private client: Client;
  private messages: string[] = [];

  constructor() {
    // Initialize the STOMP client with SockJS
    this.client = new Client({
      webSocketFactory: () => new SockJS('http://localhost:8080/chat'),
      reconnectDelay: 5000, // Reconnect automatically after 5 seconds if disconnected
    });

    this.client.onConnect = () => {
      console.log('Connected to WebSocket');
      // Subscribe to the topic for messages
      this.client.subscribe('/topic/messages', (message: IMessage) => {
        if (message.body) {
          try {
            const parsedMessage = JSON.parse(message.body);
            if (parsedMessage.content) {
              this.messages.push(parsedMessage.content);
            }
          } catch (error) {
            console.error('Error parsing message body:', error);
          }
        }
      });
    };

    this.client.onStompError = (frame) => {
      console.error('Broker reported error:', frame.headers['message']);
      console.error('Additional details:', frame.body);
    };

    this.client.onDisconnect = () => {
      console.log('Disconnected from WebSocket');
    };
  }

  /**
   * Connect to the WebSocket server
   */
  connect(): void {
    this.client.activate();
  }

  /**
   * Disconnect from the WebSocket server
   */
  disconnect(): void {
    if (this.client && this.client.connected) {
      this.client.deactivate();
      console.log('Disconnected from WebSocket');
    }
  }

  /**
   * Send a message through the WebSocket
   * @param sender Sender name
   * @param content Message content
   */
  sendMessage(sender: string, content: string): void {
    const message = { sender, content };
    const headers: StompHeaders = {};
    if (this.client && this.client.connected) {
      this.client.publish({
        destination: '/app/sendMessage',
        body: JSON.stringify(message),
        headers,
      });
    } else {
      console.error('Cannot send message. WebSocket is not connected.');
    }
  }

  /**
   * Retrieve the list of messages
   * @returns Array of messages
   */
  getMessages(): string[] {
    return this.messages;
  }
}
