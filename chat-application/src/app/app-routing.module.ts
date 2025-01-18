import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'chat', // Route to the ChatModule
    loadChildren: () => import('./chat/chat.module').then((m) => m.ChatModule),
  },
  { path: '', redirectTo: 'chat', pathMatch: 'full' }, // Default route
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
