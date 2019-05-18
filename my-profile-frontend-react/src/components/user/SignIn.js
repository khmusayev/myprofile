import React, { Component } from 'react';
import InputGroup from 'react-bootstrap/InputGroup';
import FormControl from 'react-bootstrap/FormControl';
import Button from 'react-bootstrap/Button';
import axios from 'axios';
import * as Constants from '../utils/Constants';
import AuthService from '../service/AuthService'
import createBrowserHistory from 'history/createBrowserHistory'
import {browserHistory} from 'react-router'

class SignIn extends Component {

    constructor(props) {
        super(props);

        this.state = {
            username: "",
            password: ""
        };
    }

    validateForm() {
        return this.state.username.length > 0 && this.state.password.length > 0;
    }

    submitSignIn = (e) => {
        browserHistory.push(`/users/khmu`);
    }

    onUsernameChange(e) {
        this.setState({ username: e.target.value });
    }

    onPasswordChange(e) {
        this.setState({ password: e.target.value });
    }

    render() {
        console.log(this.state);
        return (
            <>
                <InputGroup className="mb-3">
                    <InputGroup.Prepend>
                        <InputGroup.Text id="sgni-username"><strong>Username</strong></InputGroup.Text>
                    </InputGroup.Prepend>
                    <FormControl

                        aria-describedby="sgni-username"
                        value={this.state.username}
                        onChange={this.onUsernameChange.bind(this)}
                        name="username"
                    />
                </InputGroup>

                <InputGroup className="mb-3">
                    <InputGroup.Prepend>
                        <InputGroup.Text id="sgni-password"><strong>Username</strong></InputGroup.Text>
                    </InputGroup.Prepend>
                    <FormControl

                        aria-describedby="sgni-password"
                        onChange={this.onPasswordChange.bind(this)}
                        value={this.state.password}
                        name="password"
                    />
                </InputGroup>

                <InputGroup className="mb-3">
                    <InputGroup.Prepend>
                        <Button name="signin-btn" disabled={!this.validateForm()} onClick={this.submitSignIn}>Sign In</Button>
                    </InputGroup.Prepend>
                </InputGroup>

            </>
        );
    }

}

export default SignIn;