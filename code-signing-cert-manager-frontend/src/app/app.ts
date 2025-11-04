import { Component } from '@angular/core';
import { RouterOutlet, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, RouterLink],
  template: `
    <div class="app-container">
      <nav class="navbar">
        <h1>Certificate Manager</h1>
        <div class="nav-links">
          <a routerLink="/certificates" routerLinkActive="active">Certificates</a>
          <a routerLink="/certificates/add" routerLinkActive="active">Add Certificate</a>
          <a routerLink="/sign" routerLinkActive="active">Sign File</a>
          <a routerLink="/signed-files" routerLinkActive="active">Signed Files</a>
        </div>
      </nav>
      <main class="main-content">
        <router-outlet></router-outlet>
      </main>
    </div>
  `,
  styles: [`
    .app-container { min-height: 100vh; }
    .navbar { background: rgba(26, 32, 44, 0.9); backdrop-filter: blur(10px); color: white; padding: 1rem 2rem; display: flex; justify-content: space-between; align-items: center; box-shadow: 0 4px 20px rgba(0,0,0,0.1); }
    .navbar h1 { margin: 0; color: #f7fafc; }
    .nav-links { display: flex; gap: 1rem; }
    .nav-links a { color: #e2e8f0; text-decoration: none; padding: 0.5rem 1rem; border-radius: 8px; transition: all 0.3s; }
    .nav-links a:hover, .nav-links a.active { background: rgba(102, 126, 234, 0.8); color: white; transform: translateY(-1px); }
    .main-content { padding: 2rem; }
  `]
})
export class AppComponent {
  title = 'Certificate Manager';
}