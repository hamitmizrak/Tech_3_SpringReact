
// Axios
import axios from "axios";

// Persist Data Url
const PERSIST_URL = "/register/api/v1.0.0";

class RegisterApi {

    // SPEED DATA
    // http://localhost:4444/register/api/v1.0.0/speed/data/10
    // @GetMapping("/speed/data/{id}")
    registerApiSpeedData(id) {
        return axios.get(`${PERSIST_URL}/speed/data/${id}`)
    }

    // DELETE ALL
    // http://localhost:4444/register/api/v1.0.0/delete/all
    // target@GetMapping("/delete/all")
    registerApiDeleteAll() {
        return axios.get(PERSIST_URL + "/delete/all")
    }
    ///////////////////////////////////////////////////////////////////////////

    // SEARCH
    // LOGIN
    // http://localhost:4444/register/api/v1.0.0/search?surname=mizrak
    //@GetMapping("/search")
    loginApiFindBySurname(surname) {
        return axios.get((`${PERSIST_URL}/search?${surname}`));
    }

    ///////////////////////////////////////////////////////////////////////////
    // CREATE
    // http://localhost:4444/register/api/v1.0.0/create
    // @PostMapping("/create")
    registerApiCreate(registerDto) {
        return axios.post(`${PERSIST_URL}/create`, registerDto, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(registerDto),
        })
    }

    // LIST
    // http://localhost:4444/register/api/v1.0.0/list
    // @GetMapping("/list")
    registerApiList() {
        return axios.get(`${PERSIST_URL}/list`)
    }

    // FIND BY ID
    // http://localhost:4444/register/api/v1.0.0/find/1
    // @GetMapping("/find/{id}")
    registerApiFindById(id) {
        return axios.get(`${PERSIST_URL}/find/${id}`)
    }

    // UPDATE
    // http://localhost:4444/register/api/v1.0.0/update/1
    // @PutMapping(value = "/update/{id}")
    registerApiUpdate(id, registerDto) {
        return axios.put(`${PERSIST_URL}/update/${id}`, registerDto)
    }

    // DELETE BY ID
    // http://localhost:4444/register/api/v1.0.0/delete/1
    // @DeleteMapping("/delete/{id}")
    registerApiDeleteById(id) {
        return axios.delete(`${PERSIST_URL}/delete/${id}`)
    }

} //end class

export default new RegisterApi()
