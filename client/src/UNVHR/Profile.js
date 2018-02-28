import React from 'react';
import './Profile.css';

export class Profile extends React.Component{
  constructor() {
    super();
    this.state = {
      user: {
        firstName: 'not loaded yet',
        lastName: 'l not loaded yet',
      },
    };
  }

  componentDidMount() {
    fetch('http://localhost:8080/user/1')
    .then(results => {
      return results.json();
    })
    .then(data => {
      let user = data;
      this.setState({user: user});
      console.log("state", this.state.user);
    });
  }

  render(){
    return (
        <div className="wrapper" >
            <h1>Profile</h1>
            <ul>
              <li>First Name: {this.state.user.firstName}</li>
              <li>Last Name: {this.state.user.lastName}</li>
            </ul>
        </div>
    );
  }
};