import { Component } from '@angular/core';
import { ChatComponent } from './chat/chat.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ChatComponent],
  template: `
    <h1>Welcome to the Chat Application</h1>
    <app-chat></app-chat>
  `
})
export class AppComponent {}
