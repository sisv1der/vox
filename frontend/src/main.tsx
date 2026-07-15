import { oidcConfig } from '@/auth/oidcConfig'
import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import '@/index.css'
import Vox from '@/vox/Vox.tsx'
import { AuthProvider } from 'react-oidc-context'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <AuthProvider
      {...oidcConfig}
    >
      <Vox />
    </AuthProvider>
  </StrictMode>
)
