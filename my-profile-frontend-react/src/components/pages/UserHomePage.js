import React, {Component} from 'react';
import Tabs from 'react-bootstrap/Tabs';
import Tab from 'react-bootstrap/Tab';
import User from '../user/User';
import Contact from '../user/Contact';
import Education from '../user/Education';
import Job from '../user/Job';
import * as Constants from '../utils/Constants';
import axios from 'axios';

class UserHomePage extends Component {
    state = {
        user: {username: "", firstName: "", lastName: "", email: ""}, 
        educationList: [],
        jobList: [],
        contact: {address: "", email: "", phone: ""}
    }

    componentDidMount() {
        console.log("inside UserHomePage.js")
        const {username} = this.props.match.params;
        axios.get(`${Constants.BASE_USER_URL}/username/${username}`)
        .then(res => {
            const user = res.data;
            console.log(res.data);
            this.setState({
                user: user, 
                educationList: user.userEdus, 
                jobList: user.userJobs,
                contact: user.userContact
            });
        });
    }
    render() {
        console.log(this.state);
        return (
            <React.Fragment>
                <Tabs defaultActiveKey="user" >
                    <Tab eventKey="user" title="User Details">
                        <User user={this.state.user} />
                    </Tab>
                    <Tab eventKey="education" title="Education Background">
                        <Education  educationList={this.state.educationList} />
                    </Tab>
                    <Tab eventKey="job" title="Job Background">
                        <Job jobList={this.state.jobList} />
                    </Tab>
                    <Tab eventKey="contact" title="Contact Information">
                        <Contact contact={this.state.contact} />
                    </Tab>
                </Tabs>
            </React.Fragment>
        );
    }
}


export default UserHomePage;