import { api } from '@/api/client'
import { useAuth } from 'react-oidc-context'

export interface DebugResponse {
  name: string
  authorities: AuthorityResponse[]
}

export interface AuthorityResponse {
  authority: string
}

const Vox = () => {
  const auth = useAuth()

  const debugApi = async () => {
    const res: DebugResponse = await api.get('/api/debug', {
      headers: {
        Authorization: `Bearer ${auth.user?.access_token}`,
      },
    })
    console.log(res)
  }

  const adminApi = async () => {
    const res: string = await api.get('api/debug/admin', {
      headers: {
        Authorization: `Bearer ${auth.user?.access_token}`,
      },
    })
    console.log(res)
  }

  if (auth.isLoading) {
    return <div>Loading...</div>
  }

  if (auth.isAuthenticated) {
    console.log(auth.user)

    return (
      <>
        <div>Logged in as {auth.user?.profile.preferred_username}</div>
        <button onClick={() => void auth.signoutRedirect()}>Log Out</button>
        <button onClick={() => void debugApi()}>Debug</button>
        <button onClick={() => void adminApi()}>Admin</button>
      </>
    )
  } else {
    return <button onClick={() => void auth.signinRedirect()}>Login</button>
  }
}

export default Vox
