import { Component, OnInit } from '@angular/core';
import { ChatService } from '../chat.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css'],
})
export class ChatComponent implements OnInit {
  messages: string[] = [];
  messageContent = '';
  sender = 'User';

  constructor(private chatService: ChatService) {}

  ngOnInit(): void {
    this.chatService.connect();
    this.messages = this.chatService.getMessages();
  }

  sendMessage(): void {
    if (this.messageContent.trim()) {
      this.chatService.sendMessage(this.sender, this.messageContent);
      this.messageContent = '';
    }
  }
}
