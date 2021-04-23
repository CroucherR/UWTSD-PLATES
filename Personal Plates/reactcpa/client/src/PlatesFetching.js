import axios from "axios";
import {useEffect, useState} from "react";


function PlatesFetching() {
    const [plates, setPlates] = useState([])

    useEffect(() => {
        axios.get('http://localhost:8080/platesdetails')
            .then(res=> {
                console.log(res)
                setPlates(res.data)
            })
            .catch(err => {
                console.log(err)
            })


    }, [])


    return(
        <div>
            <h2>Search for a Plate</h2>
                <ul>
                    {
                        plates.map(plate => <li key={plate.plateid}>{plate.registrationplate} - £{plate.cost}</li> )
                    }
                </ul>

        </div>
    )
}

export default PlatesFetching