import React, {Component} from 'react';
import InputGroup from 'react-bootstrap/InputGroup';

class TestLoggedIn extends Component {
    render() {
        console.log('xxxxxxxxxxxxxxxxxxxxxxxxxxxx')
         return (
            <>
                <InputGroup className="mb-3">
                  <InputGroup.Prepend>
                    <InputGroup.Text id="lbl-username"><strong>Username</strong></InputGroup.Text>
                  </InputGroup.Prepend>
                </InputGroup>

            </>
        );
    }
}


export default TestLoggedIn;