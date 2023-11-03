// rfce
import React, { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import RegisterApi from '../../services/RegisterApi';
import { withTranslation } from 'react-i18next';
import axios from 'axios';


// FUNCTION
function RegisterList({ t, i18n, props }) {

  // REDIRECT
  let navigate = useNavigate();

  // STATE
  const [registerApiListData, setRegisterApiListData] = useState([]); //unutma diziyi yaz

  // EFFECT
  useEffect(() => {
    //1 .YOL
    // RegisterApi.registerApiList()
    //   .then(
    //     (response) => {
    //       console.log(response);
    //       console.log(response.data);
    //       console.log(response.status);
    //       console.log(response.headers);
    //       if (response.status === 200) {
    //         setRegisterApiListData(response.data)
    //       }else 
    //       Promise.reject();
    //     }
    //   )
    //   .catch((err) => {
    //     console.log(err);
    //   });

      //2.YOL
      fetchRegisterList();
  }, []) //end useEffect

  // Fetch users from API
  const fetchRegisterList = async () => {
    try {
      const response = await  RegisterApi.registerApiList()  //fetch('https://api.example.com/users');
      setRegisterApiListData(response.data)
    } catch (error) {
      console.error('Error fetching users:', error);
    }
  };


  // FUNCTION

  // LIST AFTER LOADING
  const listManipulationAfter = () => {
    RegisterApi.registerApiList()
      .then(
        (response) => {
          console.log(response);
          console.log(response.data);
          console.log(response.status);
          console.log(response.headers);
          if (response.status === 200) {
            setRegisterApiListData(response.data)
          }
        }
      )
      .catch((err) => {
        console.log(err);
      });
  }

  // SPEED DATA
  const speedData = async () => {
    const userData = prompt("Kaç tane veri eklemek istiyor sunuz ?")
    let response = await RegisterApi.registerApiSpeedData(userData);
    if (response.status === 200) {
      console.log("Speed Data");
      listManipulationAfter();
      navigate('/register/list')
      //window.location="/register/list"
    }
  }

  // DELETE ALL
  const deleteAll = () => {
    if (window.confirm("Bütün verileri silmek istiyor musunuz ?")) {
      RegisterApi.registerApiDeleteAll()
        .then((response) => {
          if (response.status === 200) {
            listManipulationAfter();
            //navigate('/register/list')
            window.location = "/register/list"
          }
        })
        .catch((err) => { console.log(err); })
    } else {
      alert("Silinmedi")
    }
  }

  ////////////////////////////
  // CRUD
  // REGISTER UPDATE
  const setUpdateRegister = (data) => {
    // 1.YOL (id useParams)
    // 2.YOL (localStorage)
    let { id, registerNickName, registerName, registerSurname, registerEmail, registerPassword, registerIsPassive } = data
    localStorage.setItem("register_update_id", id)
    localStorage.setItem("register_update_nick_name", registerNickName)
    localStorage.setItem("register_update_name", registerName)
    localStorage.setItem("register_update_surname", registerSurname)
    localStorage.setItem("register_update_email", registerEmail)
    localStorage.setItem("register_update_password", registerPassword)
    localStorage.setItem("register_update_is_passive", registerIsPassive)
  }

  // REGISTER VIEW
  const setViewRegister = (id) => {
    // 1.YOL (id useParams)
    // 2.YOL (localStorage)
    localStorage.setItem("register_view_id", id)
  }

  //REGISTER DELETE
  const setDeleteRegister = (id) => {
    if (window.confirm(id + " silmek istiyor musunuz ?")) {
      // 1.YOL
      RegisterApi.registerApiDeleteById(id)
        .then((response) => {
          if (response.status === 200) {
            listManipulationAfter();
            navigate('/register/list')
            //window.location = "/register/list"
          }
        })
        .catch((err) => {
          console.error(err);
          navigate('/register/list')
          //window.location = "/register/list"
        });
    } else {
      alert(id + " nolu data silinmedi !!!");
      //navigate('/register/list')
      window.location = "/register/list"
    }

    // 2.YOL (delete axios yazarak)
    // axios.delete(" http://localhost:4444/register/api/v1.0.0/delete/"+id).then().catch();
  }


  // RETURN
  return (
    <React.Fragment>
      <br /><br /><br /><br />
      <h1>{t('register_list')}</h1>
      <Link className='btn btn-primary me-2' to="/register/create">{t('create')}</Link>
      <Link className='btn btn-secondary me-2' onClick={speedData}>{t('create_all')}</Link>
      <Link className='btn btn-danger' onClick={deleteAll}>{t('delete_all')}</Link>
      <table className='table table-striped table-responsive mb-5'>
        <thead>
          <tr>
            <th>{t('id')}</th>
            <th>{t('user_nickname')}</th>
            <th>{t('user_name')}</th>
            <th>{t('user_surname')}</th>
            <th>{t('user_email')}</th>
            <th>{t('user_password')}</th>
            <th>{t('user_is_passive')}</th>
            <th>{t('system_date')}</th>
            <th>{t('update')}</th>
            <th>{t('show')}</th>
            <th>{t('delete')}</th>
          </tr>
        </thead>
        <tbody>
          {
            registerApiListData.map((data) =>
              <tr key={data.id}>
                <td>{data.id}</td>
                <td>{data.registerNickName}</td>
                <td>{data.registerName}</td>
                <td>{data.registerSurname}</td>
                <td>{data.registerEmail}</td>
                <td>{(data.registerPassword)}</td>
                <td>{data.registerIsPassive ?"Kullanıcı Aktif":"Kullanıcı Pasif"}</td>
                <td>{data.systemDate}</td>
                <td>
                  <Link to={`/register/update/${data.id}`}>
                    <i onClick={() => setUpdateRegister(data)} className="fa-solid fa-pen-nib text-primary"></i>
                  </Link>
                </td>
                <td>
                  <Link to={`/register/view/${data.id}`}>
                    <i onClick={() => setViewRegister(data.id)} className="fa-solid fa-eye text-secondary"></i>
                  </Link>
                </td>
                <td>
                  <Link>
                    <i onClick={() => setDeleteRegister(data.id)} className="fa-solid fa-trash text-danger"></i>
                  </Link>
                </td>
              </tr>
            )
          }
        </tbody>
      </table>
    </React.Fragment>
  ) //end return
} //end class

// i18n
export default withTranslation()(RegisterList)