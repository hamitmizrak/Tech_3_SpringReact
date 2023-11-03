// rcc
import React, { Component } from 'react';
import { withTranslation } from 'react-i18next';

// Class  Footer Component
class Footer extends Component {
    constructor(props) {
        super(props);

        // STATE
        this.state = {

        }

        // BIND
    }

    // CDM

    // Function
    nowDate() {
        return new Date().getFullYear();
    }


    // RENDER
    render() {

        // RETURN
        return (
            <>
                <footer className="bg-light text-center text-lg-start fixed-bottom">
                    <div
                        className="text-center p-3"
                        style={{ backgroundColor: "rgba(0, 0, 0, 1)", color: "white" }}
                    >
                        © 2020 - {this.nowDate()} Copyright:
                        <a className="text-dark" href="#!">
                            blog Project
                        </a>
                    </div>
                    {/* Copyright */}
                </footer>

            </>
        );
    }
}

//Export
export default withTranslation()(Footer);