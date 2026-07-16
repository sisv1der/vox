import axios from 'axios'

const API_URL: string = import.meta.env.VITE_API_URL

export interface PageResponse<T> {
    content: T[]
    totalPages: number
    totalElements: number
    size: number
    number: number
}

export interface PageableRequest {
    page?: number
    size?: number
}

export const api = axios.create({
    baseURL: API_URL,
    withCredentials: true,
    headers: {
        'Content-Type': 'application/json',
    },
})