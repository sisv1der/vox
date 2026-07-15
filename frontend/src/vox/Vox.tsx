import { useAuth } from 'react-oidc-context'

const Vox = () => {
  const auth = useAuth()

  if (auth.isLoading) {
    return <div>Loading...</div>
  }

  if (auth.isAuthenticated) {
    console.log(auth.user)

    return (
      <>
        <div>Logged in as {auth.user?.profile.preferred_username}</div>
        <button onClick={() => void auth.signoutRedirect()}>Log Out</button>
      </>
    )
  } else {
    return <button onClick={() => void auth.signinRedirect()}>Login</button>
  }
}

export default Vox
