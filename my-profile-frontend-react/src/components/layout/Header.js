import React from 'react';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import NavLink from 'react-bootstrap/NavLink';
import {LinkContainer} from 'react-router-bootstrap';
import logo from '../../resources/images/logo.svg';
import Image from 'react-bootstrap/Image';

function Header() {
    return (
        <Navbar bg="dark" variant="dark">
            <Navbar.Brand href="#">
                <Image src={logo}
                        width="50"
                        height="50"
                        className="d-inline-block align-top"
                        alt="Application Logo" />
            </Navbar.Brand>
            <Nav className="mr-auto" navbar>
                <LinkContainer to="/">
                    <NavLink>Login</NavLink>
                </LinkContainer>
                <LinkContainer to="/users/niag">
                    <NavLink>Home</NavLink>
                </LinkContainer>
            </Nav>
        </Navbar>
    )
}

export default Header;