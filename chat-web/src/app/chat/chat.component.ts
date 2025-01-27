import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-chat',
  imports: [],
  templateUrl: './chat.component.html',
  styleUrl: './chat.component.css'
})
export class ChatComponent {
  message: string = '';

  constructor(private http: HttpClient) {}

  sendMessage() {
    this.http.post('http://localhost:3000/message', { message: this.message })
      .subscribe((response) => {
        console.log(response);
      });
  }
}
