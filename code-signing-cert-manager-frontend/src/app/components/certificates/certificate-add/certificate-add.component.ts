import { Component, inject } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { CertificateService } from '../../../services/certificate.service';

@Component({
  selector: 'app-certificate-add',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  template: `
    <div style="text-align: center;">
      <h2>Add Certificate</h2>
      <form [formGroup]="certForm" (ngSubmit)="onSubmit()" class="form">
      <label>Certificate Name:</label>
      <input formControlName="certificateName" type="text" />
      <label>Issuer Name:</label>
      <input formControlName="issuerName" type="text" />
      <label>Valid From:</label>
      <input formControlName="validFrom" type="date" />
      <label>Valid To:</label>
      <input formControlName="validTo" type="date" />
      <button type="submit" [disabled]="certForm.invalid">Add</button>
      </form>
    </div>
  `,
  styles: [`
    .form { display: flex; flex-direction: column; max-width: 400px; gap: 10px; margin: 0 auto; text-align: left; }
    label { font-weight: bold; }
    input { padding: 8px; border: 1px solid #ccc; border-radius: 4px; }
    button { padding: 12px; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; border: none; border-radius: 8px; cursor: pointer; font-weight: 600; }
    button:disabled { background: #ccc; cursor: not-allowed; }
  `]
})
export class CertificateAddComponent {
  private fb = inject(FormBuilder);
  private certService = inject(CertificateService);
  private router = inject(Router);

  certForm = this.fb.group({
    certificateName: ['', Validators.required],
    issuerName: ['', Validators.required],
    validFrom: ['', Validators.required],
    validTo: ['', Validators.required]
  });

  onSubmit() {
    if (this.certForm.invalid) return;
    const val = this.certForm.value;
    this.certService.create(val).subscribe(() => {
      alert('Certificate Added Successfully!');
      this.router.navigate(['/certificates']);
    });
  }
}