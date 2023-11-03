// React, useState
import React, { useEffect, useState } from 'react'

// i18n
import { withTranslation } from 'react-i18next'

// Router, Params
import { useNavigate, useParams } from 'react-router-dom'

// Register Api
import RegisterApi from '../../services/RegisterApi';

// Image
import sunrise from '../../image/apartment.jpg';

// REGISTER VIEW FUNCTION
function RegisterView({ props, t, i18n }) {

  // REDIRECT
  let navigate = useNavigate();

  // STATE
  const [id, setId] = useState(null);
  const [registerViewState, setRegisterViewState] = useState([]);

  // PARAMS (ID)
  const parametersHandlingViewId = useParams();

  // EFFECT
  useEffect(() => {
    // 1.YOL LocalStorage
    setId(localStorage.getItem("register_view_id"))

    // 2.YOL useParams
    setId(parametersHandlingViewId.id);

    //FIND BY ID
    RegisterApi.registerApiFindById(parametersHandlingViewId.id)
      //RegisterApi.registerApiFindById(localStorage.getItem("register_view_id")) //2.YOL
      .then((response) => {
        console.log(response);
        // console.log(response.data);
        // console.log(response.status);
        // console.log(response.headers);
        if (response.status == 200) {
          setRegisterViewState(response.data);
        }

      })
      .catch((err) => {
        console.error(err);
      });
  }, []); //end useEffect

  // RETURN
  return (
    <React.Fragment>
      <h1 className="text-center display-3">{t('register_show')}</h1>
      <div className="card">
        <img className="card-img-top" src={sunrise} alt="Title" />
        <div className="card-body">
          <h4 className="card-title">{registerViewState.id}</h4>
          <p className="card-text">{registerViewState.registerNickName}</p>
          <p className="card-text">{registerViewState.registerName}</p>
          <p className="card-text">{registerViewState.registerSurname}</p>
          <p className="card-text">{registerViewState.registerEmail}</p>
          <p className="card-text">{registerViewState.registerPassword}</p>
          <p className="card-text">{registerViewState.registerIsPassive?"Kullanıcı Aktif":"Kullanıcı Pasif"}</p>
          <br /><br /><br /><br /><br /><br />
        </div>
      </div>

    </React.Fragment>
  )// end return
} //end RegisterView


// EXPORT
export default withTranslation()(RegisterView)
