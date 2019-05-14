import React, {Component} from 'react';
import InputGroup from 'react-bootstrap/InputGroup';
import FormControl from 'react-bootstrap/FormControl';
import Card from 'react-bootstrap/Card';
import PropTypes from 'prop-types';

class EducationItem extends Component {
    render() {
        return (
            <Card bg={this.props.randColors.bgColor} 
                text={this.props.randColors.textColor} 
                border={this.props.randColors.borderColor}
                style = {{ width: '18rem'}}>
                <Card.Header>{this.props.education.university}</Card.Header>
                <Card.Body>
                    <InputGroup className="mb-3">
                        <InputGroup.Prepend>
                        <InputGroup.Text id="lbl-university"><strong>University</strong></InputGroup.Text>
                        </InputGroup.Prepend>
                        <FormControl
                        placeholder="University"
                        aria-label="University"
                        aria-describedby="lbl-university"
                        value={this.props.education.university}
                        name="university"
                        readOnly
                        />
                    </InputGroup>

                    <InputGroup className="mb-3">
                        <InputGroup.Prepend>
                        <InputGroup.Text id="lbl-faculty"><strong>Faculty</strong></InputGroup.Text>
                        </InputGroup.Prepend>
                        <FormControl
                        placeholder="Faculty"
                        aria-label="Faculty"
                        aria-describedby="lbl-faculty"
                        value={this.props.education.faculty}
                        name="faculty"
                        readOnly
                        />
                    </InputGroup>

                    <InputGroup className="mb-3">
                        <InputGroup.Prepend>
                        <InputGroup.Text id="lbl-degree"><strong>Degree</strong></InputGroup.Text>
                        </InputGroup.Prepend>
                        <FormControl
                        placeholder="Degree"
                        aria-label="Degree"
                        aria-describedby="lbl-degree"
                        value={this.props.education.degree}
                        name="degree"
                        readOnly
                        />
                    </InputGroup>

                    <InputGroup className="mb-3">
                        <InputGroup.Prepend>
                        <InputGroup.Text id="lbl-courseDescription"><strong>Course description</strong></InputGroup.Text>
                        </InputGroup.Prepend>
                        <FormControl
                        placeholder="Course description"
                        aria-label="CourseDescription"
                        aria-describedby="lbl-courseDescription"
                        value={this.props.education.courseDescription}
                        name="courseDescription"
                        readOnly
                        />
                    </InputGroup>

                    <InputGroup className="mb-3">
                        <InputGroup.Prepend>
                        <InputGroup.Text id="lbl-startDate"><strong>StartDate</strong></InputGroup.Text>
                        </InputGroup.Prepend>
                        <FormControl
                        placeholder="StartDate"
                        aria-label="StartDate"
                        aria-describedby="lbl-startDate"
                        value={this.props.education.startDate}
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
                        value={this.props.education.endDate}
                        name="endDate"
                        readOnly
                        />
                    </InputGroup>
                </Card.Body>
            </Card>
        );
    }
}


EducationItem.propTypes = {
    randColors: PropTypes.object.isRequired,
    education: PropTypes.object.isRequired
}

export default EducationItem;