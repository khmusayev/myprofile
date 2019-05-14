import React, {Component} from 'react';
import InputGroup from 'react-bootstrap/InputGroup';
import FormControl from 'react-bootstrap/FormControl';
import PropTypes from 'prop-types';

class User extends Component {
    render() {
        return (
            <>
                <InputGroup className="mb-3">
                  <InputGroup.Prepend>
                    <InputGroup.Text id="lbl-username"><strong>Username</strong></InputGroup.Text>
                  </InputGroup.Prepend>
                  <FormControl
                    placeholder="Username"
                    aria-label="Username"
                    aria-describedby="lbl-username"
                    value={this.props.user.username}
                    name="username"
                    readOnly
                />
                </InputGroup>

                <InputGroup className="mb-3">
                    <InputGroup.Prepend>
                        <InputGroup.Text id="lbl-firstName"><strong>FirstName</strong></InputGroup.Text>
                    </InputGroup.Prepend>
                    <FormControl
                        placeholder="FirstName"
                        aria-label="FirstName"
                        aria-describedby="lbl-firstName"
                        value={this.props.user.firstName}
                        name="firstName"
                        readOnly
                    />
                </InputGroup>
                
                <InputGroup className="mb-3">
                    <InputGroup.Prepend>
                        <InputGroup.Text id="lbl-lastName"><strong>LastName</strong></InputGroup.Text>
                    </InputGroup.Prepend>
                    <FormControl 
                        placeholder="LastName"
                        aria-label="LastName"
                        aria-describedby="lbl-lastName"
                        value={this.props.user.lastName}
                        name="lastName"
                        readOnly
                    />
                </InputGroup>

                <InputGroup className="mb-3">
                    <InputGroup.Prepend>
                        <InputGroup.Text id="lbl-email"><strong>Email</strong></InputGroup.Text>
                    </InputGroup.Prepend>
                    <FormControl
                        placeholder="Email"
                        aria-label="Email"
                        aria-describedby="lbl-email"
                        value={this.props.user.email}
                        name="email"
                        readOnly
                    />
                </InputGroup>

            </>
        );
    }
}


User.propTypes = {
    user: PropTypes.object.isRequired
}


export default User;