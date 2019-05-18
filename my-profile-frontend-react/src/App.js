import React from 'react';
import './App.css';
import Header from './components/layout/Header';
import AuthenticationPage from './components/pages/AuthenticationPage';
import UserHomePage from './components/pages/UserHomePage';
import { BrowserRouter as Router , Route} from 'react-router-dom';
import {browserHistory} from 'react-router';

function App() {
  return (
    <Router history={browserHistory}>
      <div className="App">
        <div className="container">
          <Header />
          <Route exact path="/" component={AuthenticationPage} />
          <Route exact path="/users/:username" component={UserHomePage} />
        </div>
      </div>
    </Router>
  );
}

export default App;
