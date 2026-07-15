import { useAuth } from 'react-oidc-context'

const Vox = () => {
  const auth = useAuth()

  if (auth.isLoading) {
    return <div>Loading...</div>
  }

  if (auth.isAuthenticated) {
    return <div>Logged in as {auth.user?.profile.preferred_username}</div>
  }

  return <button onClick={() => void auth.signinRedirect()}>Login</button>
}

export default Vox
