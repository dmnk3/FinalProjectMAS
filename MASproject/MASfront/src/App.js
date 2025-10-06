import MainMenu from "./components/MainMenu";
import HeaderComponent from "./components/HeaderComponent";
import PojazdyComponent from "./components/PojazdyComponent";

import {BrowserRouter as Router, Routes, Route} from "react-router-dom";

function App() {
  return (
  <Router>
      <HeaderComponent/>
      <div className="divmain">
        <Routes>
          <Route path="/" element={<MainMenu/>}/>
          <Route path="/klient/:klientId" element={<PojazdyComponent/>}/>
        </Routes>
      </div>
  </Router>
)
}

export default App;