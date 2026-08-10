import { useState } from 'react'
import './App.css'

function App() {
  const [n, setN] = useState('')
  const [result, setResult] = useState(null)
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState(null)

  async function fetchFib() {
    setLoading(true)
    setError(null)
    setResult(null)
    try {
      const q = encodeURIComponent(n)
      const res = await fetch(`/fib?n=${q}`)
      if (!res.ok) throw new Error(`HTTP ${res.status}`)
      const text = await res.text()
      setResult(text)
    } catch (err) {
      setError(err.message || 'Error fetching')
    } finally {
      setLoading(false)
    }
  }

  return (
    <div className="calculator-root">
      <h1>Fibonacci Calculator</h1>
      <div className="calculator">
        <label htmlFor="n">Enter n (non-negative integer)</label>
        <input
          id="n"
          type="number"
          min="0"
          value={n}
          onChange={(e) => setN(e.target.value)}
          placeholder="e.g. 10"
        />
        <button onClick={fetchFib} disabled={loading || n === ''}>
          {loading ? 'Calculating…' : 'Calculate'}
        </button>
      </div>

      <div className="output">
        {error && <div className="error">Error: {error}</div>}
        {result !== null && !error && (
          <div className="result">F({n}) = {result}</div>
        )}
      </div>
    </div>
  )
}

export default App
