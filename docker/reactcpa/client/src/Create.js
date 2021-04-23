import {useEffect, useRef, useState} from "react";
import axios from "axios";
var swearjar = require('swearjar');


const Create = () => {
    const [plates, setPlates] = useState([])
    const [id,setId] = useState( )
    const [customerid,setcustomerid] = useState( )
    const [paymentid,setpaymentid] = useState( )
    const [plateid,setplateid] = useState( )


    useEffect(() => {
        axios.get('http://localhost:8080/plates/search/findByRegistrationplateIgnoreCase?registrationplate='+id, {mode:  'no-cors'})
            .then(res=> {
                console.log(res.data._embedded.plates)
                setPlates(res.data._embedded.plates)
            })
            .catch(err => {
                console.log(err)
            })


    }, [id])

    var notAvail =false;
    var cost =1;
    var undefinedid = false;

    if (plates.length ===0){
        notAvail =false;
    }
    else {
        notAvail =true;
    }

    if (id === undefined){
        undefinedid = true;
    }
    else {
        cost = Math.round(10000/id.length)
    }
    var swear = swearjar.profane(id)

    const fnameRef = useRef();
    const snameRef = useRef();
    const addressRef = useRef();
    const methodRef = useRef();


    const handleSubmit = () => {
        console.log(fnameRef.current.value, snameRef.current.value, addressRef.current.value, methodRef.current.value);
        const customerref = {
            firstname: '' + fnameRef.current.value + '',
            secondname: '' + snameRef.current.value + '',
            address: '' + addressRef.current.value + ''
        }
        const paymentref = {cost: '' + cost + '', method: '' + methodRef.current.value + ''}
        axios.post('http://localhost:8080/customer', customerref)
            .then(response => {
                console.log(response)
                setcustomerid(response.data.customerid)
            });
        axios.post('http://localhost:8080/payment', paymentref)
            .then(response => {
                console.log(response)
                setpaymentid(response.data.paymentid)
            });

    }
    const handlePlate = () => {
        console.log(paymentid,customerid);
        const platesref = {registrationplate: '' + id + '',customer: 'http://localhost:8080/customer/'+customerid, payment: 'http://localhost:8080/payment/'+paymentid}
        axios.post('http://localhost:8080/plates', platesref)
            .then(response => {
                console.log(response)
                setplateid(response.data.plateid)
            });


    }


    if (undefinedid===true){
        return(
            <div className="box">
                <h2>Create a new plate</h2>
                <br/>
                <input type="text" className="registration-ui" value={id} onChange={e => setId(e.target.value)}/>
            </div>)}
    else if (swear===true){
        return(
            <div className="box">
                <h2>Create a new plate</h2>
                <br/>
                <input type="text" className="registration-ui" value={id} onChange={e => setId(e.target.value)}/>
                <br/>
                <h3>Please refrain from profanity</h3>
            </div>)}
    else if (swear===false && notAvail===true){
        return(
            <div className="box">
                <h2>Create a new plate</h2>
                <br/>
                <input type="text" className="registration-ui" value={id} onChange={e => setId(e.target.value)}/>
                <br/>
                <h3>Plate not availible</h3>
            </div>
        )}
    else {
        return(
            <div className="box">
                <h2>Create a new plate</h2>
                <br/>
                <input type="text" className="registration-ui" value={id} onChange={e => setId(e.target.value)}/>
                <br/>
                <h3>Plate available </h3>
                <br/>
                <h3>Plate cost: £{cost}</h3>
                <br/>
                <form>
                    <label for="fname">First Name:</label><br/>
                    <input type="text" id="fname" name="fname" ref={fnameRef}/><br/><br/>
                    <label htmlFor="sname">Second Name:</label><br/>
                    <input type="text" id="sname" name="sname" ref={snameRef}/><br/><br/>
                    <label htmlFor="address">Address:</label><br/>
                    <input type="text" id="address" name="address" ref={addressRef}/><br/><br/>
                    <label htmlFor="paymentmethod">Payment Method (PayPal, Card, etc):</label><br/>
                    <input type="text" id="paymentmethod" name="paymentmethod" ref={methodRef}/><br/><br/>
                    <button type='button' onClick={handleSubmit}>Submit Details</button><br/><br/>
                    <button type='button' onClick={handlePlate}>Register Plate</button>
                </form>
            </div>)}


}

export default Create