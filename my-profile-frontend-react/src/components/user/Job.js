import React, {Component} from 'react';
import CardDeck from 'react-bootstrap/CardDeck';
import JobItem from './JobItem';
import * as Constants from '../utils/Constants';
import PropTypes from 'prop-types';

class Job extends Component {
    render() {
        return (
            <CardDeck>
                {this.props.jobList.map(one => (
                    <JobItem key={one.id} job={one} randColors={Constants.generateRandColors()} />                    
                ))}
            </CardDeck>
        );
    }
}

Job.propTypes = {
    jobList: PropTypes.array.isRequired
}



export default Job;

