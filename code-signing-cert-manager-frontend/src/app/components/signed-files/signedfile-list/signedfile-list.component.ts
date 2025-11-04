import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SignedFileService } from '../../../services/signedfile.service';

@Component({
  selector: 'app-signedfile-list',
  standalone: true,
  imports: [CommonModule],
  template: `
    <h2>Signed Files</h2>
    <table border="1" cellpadding="6">
      <tr>
        <th>File Name</th>
        <th>Certificate Used</th>
        <th>Status</th>
        <th>Signed At</th>
      </tr>
      <tr *ngFor="let s of signedFiles">
        <td>{{ s.fileName }}</td>
        <td>{{ s.certificateName }}</td>
        <td>{{ s.status }}</td>
        <td>{{ s.signedAt | date:'short' }}</td>
      </tr>
    </table>
  `,
  styles: [`
    table { width: 100%; border-collapse: collapse; margin-top: 20px; }
    th { background: linear-gradient(135deg, #48bb78 0%, #38a169 100%); color: white; padding: 12px; text-align: left; font-weight: 600; }
    td { padding: 12px; }
    tr:nth-child(even) { background: #f9f9f9; }
  `]
})
export class SignedFileListComponent implements OnInit {
  private signService = inject(SignedFileService);
  signedFiles: any[] = [];

  ngOnInit() {
    this.signService.getAll().subscribe(res => this.signedFiles = res);
  }
}