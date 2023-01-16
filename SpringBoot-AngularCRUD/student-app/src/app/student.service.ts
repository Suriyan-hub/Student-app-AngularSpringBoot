import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Message } from './message';
import { Student } from './student';

@Injectable({
  providedIn: 'root',
})
export class StudentService {
  private baseUrl: string = 'http://localhost:8080/student';
  constructor(private http: HttpClient) {}

  getAllStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(`${this.baseUrl}/all`);
  }

  deleteStudent(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/remove/${id}`, {
      responseType: 'text',
    });
  }

  createStudent(student: Student): Observable<any> {
    return this.http.post(`${this.baseUrl}/create`, student);
  }
  getOneStudent(id: number): Observable<Student> {
    return this.http.get<Student>(`${this.baseUrl}/one/${id}`);
  }
  updateStudent(student: Student): Observable<Message> {
    return this.http.put<Message>(`${this.baseUrl}/update`, student);
  }
}
