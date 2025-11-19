import React from "react";
import { Link } from "react-router-dom"
import "./Navbar.css";
function Navbar(){
  return(
    <nav>
      <ul className="navbar-main">
        <Link to="/">Login</Link>
        <Link to="/register">Register</Link>
        <Link to="/About">About</Link>
        <Link to="/contact">Contact</Link>
      </ul>
    </nav>
  );
}
export default Navbar;