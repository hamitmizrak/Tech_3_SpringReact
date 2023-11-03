//rfc => React Function Component.
//rcc => React Class Component.
//rsc => React Stateles Component (state olmayan).
import React from 'react';

//TR import edelim
//adı tr olsun
import tr from "../image/flag/Turkish.png"
import en from "../image/flag/English.png"

// Dil secenegi
import { withTranslation } from 'react-i18next';
import OtherLanguageServices from "./OtherLanguageServices";
import { Link } from 'react-router-dom';

//Funksiyon komponent
function OtherLanguageReusability(props) {

    //Bayraklar
    const internationalizationLanguage = language => {
        const { i18n } = props;
        i18n.changeLanguage(language);

        //Hem java tarafından hemde frontend tarafından değişiklik yaptık.
        OtherLanguageServices.headerLanguageServices(language);
    }

    //render
    return (
        <React.Fragment>

            <Link className="dropdown-item" onClick={() => internationalizationLanguage('tr')}>
                <img src={tr} style={{ height: "1rem" }} alt="TR" /> TR
            </Link>
            <Link className="dropdown-item" onClick={() => internationalizationLanguage('en')}>
                <img src={en} style={{ height: "1rem" }} alt="EN" /> EN
            </Link>
        </React.Fragment>
    );
}

// export default UserRegister
// Higher Order Component: monad componenti başka bir componentin içine  ekleyip oradanda yeni sonuclar elde etmek
export default withTranslation()(OtherLanguageReusability)

