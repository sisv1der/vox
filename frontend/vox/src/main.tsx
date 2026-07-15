import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import Vox from './Vox.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <Vox />
  </StrictMode>,
)
