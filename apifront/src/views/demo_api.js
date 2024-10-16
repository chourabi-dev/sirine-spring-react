import { useEffect, useState } from "react";

export default function DemoAPi(){

    const [data, setData] = useState([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    function getDATAFromServer(){
        setLoading(true);
        const requestOptions = {
            method: "GET",
            redirect: "follow"
          };
          
          fetch("http://jsonplaceholder.typicode.com/users", requestOptions)
            .then((response) => response.json())
            .then((result) =>{
                setData(result)
            })
            .catch((error) =>{
                setError("something went wrong, refrech page");
            })
            .finally(()=>{
                setLoading(false);
            })
    }

    useEffect(()=>{
        getDATAFromServer();
    },[])

    return(
        <div>
            <h1>API Demo</h1>
            {
                loading == true ? 
                <h3>Loading....</h3> : null
            }

            {
                error != null ?
                <div className="alert alert-danger">{error}</div> : null
            }

            <div className="containet mt-5">
                <div className="row">
                    {
                        data.map((u)=>{
                            return (
                               <div className="col-sm-4 mb-3">
                                 <div key={u.id} className="card">
                                    <div className="card-body">
                                        <h5 className="card-title">{u.name}</h5>
                                        <p className="card-text">Email: {u.email}</p>
                                    </div>
                                </div>
                               </div>
                            );
                        })
                    }
                </div>
            </div>

        </div>
    );
}