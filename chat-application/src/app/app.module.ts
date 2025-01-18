import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module'; // App-level routing
import { AppComponent } from './app.component'; // Root component
import { ChatModule } from './chat/chat.module'; // Import the ChatModule

@NgModule({
  declarations: [
    AppComponent, // Declare the root component
  ],
  imports: [
    BrowserModule, // Provides Angular's browser-specific functionality
    AppRoutingModule, // Routing for the root module
    ChatModule, // Import the feature module
  ],
  providers: [],
  bootstrap: [AppComponent], // Bootstraps the root component
})
export class AppModule {}
