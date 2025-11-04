import { Component, OnInit, inject } from '@angular/core';
import { FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { SignedFileService } from '../../../services/signedfile.service';
import { CertificateService } from '../../../services/certificate.service';

@Component({
  selector: 'app-signedfile-add',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  template: `
    <h2>Sign File</h2>
    <form [formGroup]="signForm" (ngSubmit)="onSubmit()" class="form">
      <label>File Name:</label>
      <input formControlName="fileName" type="text" />
      <label>Certificate:</label>
      <select formControlName="certificateId">
        <option value="">Select Certificate</option>
        <option *ngFor="let c of certificates" [value]="c.id">{{ c.name }}</option>
      </select>
      <button type="submit" [disabled]="signForm.invalid">Sign File</button>
    </form>
  `,
  styles: [`
    .form { display: flex; flex-direction: column; max-width: 400px; gap: 10px; margin: 0 auto; }
    label { font-weight: bold; }
    input, select { padding: 8px; border: 1px solid #ccc; border-radius: 4px; }
    button { padding: 12px; background: linear-gradient(135deg, #48bb78 0%, #38a169 100%); color: white; border: none; border-radius: 8px; cursor: pointer; font-weight: 600; }
    button:disabled { background: #ccc; cursor: not-allowed; }
  `]
})
export class SignedFileAddComponent implements OnInit {
  private fb = inject(FormBuilder);
  private signService = inject(SignedFileService);
  private certService = inject(CertificateService);

  signForm = this.fb.group({
    fileName: ['', Validators.required],
    certificateId: ['', Validators.required]
  });

  certificates: any[] = [];

  ngOnInit() {
    this.certService.getAll().subscribe(certs => this.certificates = certs);
  }

  onSubmit() {
    if (this.signForm.invalid) return;
    const { fileName, certificateId } = this.signForm.value;
    this.signService.signFile(fileName!, certificateId!).subscribe(() => {
      alert('File signed successfully!');
      this.signForm.reset();
    });
  }
}