import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module'; // App-level routing
import { AppComponent } from './app.component'; // Root component
import { ChatModule } from './chat/chat.module'; // Import the ChatModule
import { ChatComponent } from './chat/chat.component'; // Import the ChatComponent
import { ChatRoutingModule } from './chat/chat-routing.module'; // Import the ChatRoutingModule

@NgModule({
  declarations: [
    AppComponent, // Declare the root component
    ChatComponent, // Declare the ChatComponent
  ],
  imports: [
    BrowserModule, // Provides Angular's browser-specific functionality
    AppRoutingModule, // Routing for the root module
    ChatModule, // Import the feature module
    ChatRoutingModule, // Routing for the
  ],
  providers: [],
  bootstrap: [AppComponent], // Bootstraps the root component
})
export class AppModule {}
