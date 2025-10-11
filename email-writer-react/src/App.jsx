import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Container } from '@mui/material';
import { Typography } from '@mui/material';

function App() {
  // const [emailContent, setEmailContent] = useState('');
  // const [tone, setTone] = useState('');
  // const [generatedRepy, setGeneratedReply] = useState('');
  // const [loading, setLoading] = useState(false);
  // const [error, setError] = useState('');

  return (
    <Container maxWidth="md" sx={{py:4}}>
      Email Reply Generator
      <Typography variant='h3' component="h1" gutterBottom>
        Email Reply Generator
      </Typography>

    </Container>
  )
}

export default App
