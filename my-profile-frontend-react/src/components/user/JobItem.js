import React, {Component} from 'react';
import Card from 'react-bootstrap/Card';
import InputGroup from 'react-bootstrap/InputGroup';
import FormControl from 'react-bootstrap/FormControl';
import PropTypes from 'prop-types';

class JobItem extends Component {
    render() {
        return (
            <Card bg={this.props.randColors.bgColor} 
                    text={this.props.randColors.textColor} 
                    border={this.props.randColors.borderColor}
                    style = {{ width: '18rem'}}
            >
                <Card.Header>{this.props.job.company}</Card.Header>
                <Card.Body>
                    <InputGroup className="mb-3">
                        <InputGroup.Prepend>
                        <InputGroup.Text id="lbl-company"><strong>Company</strong></InputGroup.Text>
                        </InputGroup.Prepend>
                        <FormControl
                        placeholder="Company"
                        aria-label="Company"
                        aria-describedby="lbl-company"
                        value={this.props.job.company}
                        name="company"
                        readOnly
                        />
                    </InputGroup>

                    <InputGroup className="mb-3">
                        <InputGroup.Prepend>
                        <InputGroup.Text id="lbl-position"><strong>Position</strong></InputGroup.Text>
                        </InputGroup.Prepend>
                        <FormControl
                        placeholder="Position"
                        aria-label="Position"
                        aria-describedby="lbl-position"
                        value={this.props.job.position}
                        name="company"
                        readOnly
                        />
                    </InputGroup>

                    <InputGroup className="mb-3">
                        <InputGroup.Prepend>
                        <InputGroup.Text id="lbl-strartDate"><strong>StartDate</strong></InputGroup.Text>
                        </InputGroup.Prepend>
                        <FormControl
                        placeholder="StartDate"
                        aria-label="StartDate"
                        aria-describedby="lbl-startDate"
                        value={this.props.job.startDate}
                        name="startDate"
                        readOnly
                        />
                    </InputGroup>

                    <InputGroup className="mb-3">
                        <InputGroup.Prepend>
                        <InputGroup.Text id="lbl-endDate"><strong>EndDate</strong></InputGroup.Text>
                        </InputGroup.Prepend>
                        <FormControl
                        placeholder="EndDate"
                        aria-label="EndDate"
                        aria-describedby="lbl-endDate"
                        value={this.props.job.endDate}
                        name="endDate"
                        readOnly
                        />
                    </InputGroup>
                </Card.Body>
            </Card>
        );
    }
}

JobItem.propTypes = {
    randColors: PropTypes.object.isRequired,
    job: PropTypes.object.isRequired
}


export default JobItem;