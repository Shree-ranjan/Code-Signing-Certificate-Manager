import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class SignedFileService {
  private http = inject(HttpClient);
  private baseUrl = `${environment.apiUrl}/signed-files`;

  getAll(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl);
  }

  signFile(fileName: string, certificateId: string): Observable<any> {
    return this.http.post(`${this.baseUrl}/sign?fileName=${fileName}&certificateId=${certificateId}`, {});
  }
}