import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent {
  message: string = '';
  messageInput: string = '';

  sendMessage() {
    this.message = this.messageInput.trim();
    this.messageInput = ''; // Clear input after sending
  }
}
