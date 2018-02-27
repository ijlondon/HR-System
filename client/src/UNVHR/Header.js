import React from 'react';
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem } from 'reactstrap';
import 'bootstrap/dist/css/bootstrap.css';  
import {Link} from 'react-router';
import './Header.css';
import logo from './logo.png';
  


  export class Header extends React.Component {
    constructor(props) {
      super(props);
  
      this.toggle = this.toggle.bind(this);
      this.state = {
        isOpen: false
      };
    }
    toggle() {
      this.setState({
        isOpen: !this.state.isOpen
      });
    }
    render() {
      return (
        <div>
          <Navbar color="faded" light expand="md">
            <NavbarBrand href="/">
            <img src={logo} style={{width:60, marginTop: -7, padding:'5px'}} />
            University HR</NavbarBrand>
            <NavbarToggler onClick={this.toggle} />
            <Collapse isOpen={this.state.isOpen} navbar>
              <Nav className="ml-auto" navbar>
                <NavItem>
                  <NavLink href="/Home">Home</NavLink>
                </NavItem>
                <NavItem>
                  <NavLink href="/Departments">Departments</NavLink>
                </NavItem>
                <NavItem>
                  <NavLink href="Profile">Profile</NavLink>
                </NavItem>
                
              </Nav>
            </Collapse>
          </Navbar>
        </div>
      );
    }
  }