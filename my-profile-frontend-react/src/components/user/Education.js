import React, {Component} from 'react';
import CardDeck from 'react-bootstrap/CardDeck';
import EducationItem from './EducationItem';
import * as Constants from '../utils/Constants';

class Education extends Component {
 
    render() {
        return (
            <CardDeck>
            {this.props.educationList.map(one => (
                <EducationItem key={one.id} 
                    education={one} 
                    randColors={Constants.generateRandColors()} />
            ))}
            </CardDeck>
        );
    }
}

export default Education;