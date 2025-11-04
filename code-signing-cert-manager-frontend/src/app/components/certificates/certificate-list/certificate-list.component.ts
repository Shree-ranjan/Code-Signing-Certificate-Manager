import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CertificateService } from '../../../services/certificate.service';

@Component({
  selector: 'app-certificate-list',
  standalone: true,
  imports: [CommonModule],
  template: `
    <h2>All Certificates</h2>
    <table border="1" cellpadding="6">
      <tr>
        <th>Name</th>
        <th>Issuer</th>
        <th>Valid From</th>
        <th>Valid To</th>
        <th>Status</th>
      </tr>
      <tr *ngFor="let cert of certificates">
        <td>{{ cert.name }}</td>
        <td>{{ cert.issuer }}</td>
        <td>{{ cert.validFrom | date }}</td>
        <td>{{ cert.validTo | date }}</td>
        <td>{{ cert.status }}</td>
      </tr>
    </table>
  `,
  styles: [`
    table { width: 100%; border-collapse: collapse; margin-top: 20px; }
    th { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; padding: 12px; text-align: left; font-weight: 600; }
    td { padding: 12px; }
    tr:nth-child(even) { background: rgba(102, 126, 234, 0.1); }
    tr:nth-child(odd):not(:first-child) { background: rgba(255, 255, 255, 0.8); }
  `]
})
export class CertificateListComponent implements OnInit {
  private certService = inject(CertificateService);
  certificates: any[] = [];

  ngOnInit() {
    this.certService.getAll().subscribe(res => this.certificates = res);
  }
}