import React, {Component} from 'react';
import InputGroup from 'react-bootstrap/InputGroup';
import FormControl from 'react-bootstrap/FormControl';
import PropTypes from 'prop-types';

class Contact extends Component {
    render() {
        return (
            <>
                <InputGroup className="mb-3">
                    <InputGroup.Prepend>
                    <InputGroup.Text id="lbl-address"><strong>Address</strong></InputGroup.Text>
                    </InputGroup.Prepend>
                    <FormControl
                    placeholder="Address"
                    aria-label="Address"
                    aria-describedby="lbl-address"
                    value={this.props.contact.address}
                    name="address"
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
                    value={this.props.contact.email}
                    name="email"
                    readOnly
                    />
                </InputGroup>

                <InputGroup className="mb-3">
                    <InputGroup.Prepend>
                    <InputGroup.Text id="lbl-phone"><strong>Phone</strong></InputGroup.Text>
                    </InputGroup.Prepend>
                    <FormControl
                    placeholder="Phone"
                    aria-label="Phone"
                    aria-describedby="lbl-phone"
                    value={this.props.contact.phone}
                    name="phone"
                    readOnly
                    />
                </InputGroup>
            </>
        );
    }
}

Contact.propTypes = {
    contact: PropTypes.object.isRequired
}

export default Contact;