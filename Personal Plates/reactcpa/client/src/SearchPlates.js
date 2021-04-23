import axios from "axios";
import {useEffect, useState} from "react";
var swearjar = require('swearjar');


function SearchPlates() {
    const [plates, setPlates] = useState([])
    const [id,setId] = useState( )

    useEffect(() => {
        axios.get('http://localhost:8080/plates/search/findByRegistrationplateContainingIgnoreCase?registrationplate='+id, {mode:  'no-cors'})
            .then(res=> {
                console.log(res.data._embedded.plates)
                setPlates(res.data._embedded.plates)
            })
            .catch(err => {
                console.log(err)
            })


    }, [id])

    var swear = swearjar.profane(id)

    if (swear===true){
        return(
            <div className="box">
                <h2>Search for a Plate</h2>
                <br/>
                <input type="text" className="registration-ui" value={id} onChange={e => setId(e.target.value)}/>
                <br/>
                <h3>Please refrain from profanity</h3>
            </div>)}
    else{
        return(
            <div className="box">
                <h2>Search for a Plate</h2>
                <br/>
                <input type="text" className="registration-ui" value={id} onChange={e => setId(e.target.value)}/>
                <br/>
                <ul>
                    {
                        plates.map(plate => <li key={plate.plateid} className="registration-ui">{plate.registrationplate}</li> )
                    }
                </ul>
            </div>
    )

    }

}

export default SearchPlates