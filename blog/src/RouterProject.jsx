import React, { Component } from 'react';
import Header from './components/Header';
import Main from './components/Main';
import Footer from './components/Footer';
import { withTranslation } from 'react-i18next';

class RouterProject extends Component {
    render() {
        return (
            <React.Fragment>
                <Header logo=""/>
                <Main/>
                <Footer/>
            </React.Fragment>
        );
    }
}

export default withTranslation()(RouterProject);