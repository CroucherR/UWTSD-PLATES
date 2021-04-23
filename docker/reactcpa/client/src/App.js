import Navbar from "./Navbar";
import Home from "./Home";
import PlatesFetching from "./PlatesFetching";
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import Create from "./Create";
import Search from "./Search";
import SearchPlates from "./SearchPlates";

function App() {

  return (
    <Router>
        <div className="App">
          <Navbar/>
          <div className="content">
              <Switch>
                  <Route exact path="/">
                      <Home/>
                  </Route>
                  <Route exact path="/create">
                      <Create/>
                  </Route>
                  <Route exact path="/search">
                      <SearchPlates/>
                  </Route>
              </Switch>
          </div>
        </div>
    </Router>
  );
}

export default App;
