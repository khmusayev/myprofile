import React, {Component} from 'react';
import Tabs from 'react-bootstrap/Tabs';
import Tab from 'react-bootstrap/Tab';
import SignIn from '../user/SignIn';

class AuthenticationPage extends Component {
    render() {
        return (
            <React.Fragment>
                <Tabs defaultActiveKey="user" >
                    <Tab eventKey="signIn" title="Sign in">
                        <SignIn sigIn />
                    </Tab>
                    <Tab eventKey="signUp" title="Sign Up">

                    </Tab>
                </Tabs>
            </React.Fragment>
        );
    }
}


export default AuthenticationPage;