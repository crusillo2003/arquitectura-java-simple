import React from 'react';
import axios from 'axios';

class LoginForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            usuario: '',
            contrasenya: '',
            login: false
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        const target = event.target;
        const value = target.type === 'checkbox'
            ? target.checked
            : target.value;
        const name = target.name;
        this.setState({[name]: value});
    }

    handleSubmit(event) {
        const promiseResult = axios.post('http://wildfly.vm:8080/UsuarioRest/api/v1/usuarios/autenticar', {
            alias: this.state.usuario,
            contrasenya: this.state.contrasenya
        }, {
            headers: {
                'Content-Type': 'application/json'
            }
        });
        var quePaso = false;
        promiseResult.then(function(result) {
            console.log(result);
            if (result.status === 200) {
                const data = result.data;
                alert('Login: ' + data.message);
                this.setState({login: true});
                quePaso = true;
            }
        });
        console.log(quePaso);

        promiseResult.catch(function(error) {
            console.log(error);
            alert("Error al autenticar");
            quePaso = true;
            console.log(quePaso);
        });

        event.preventDefault();
    }

    render() {
        return (<div>
            <form onSubmit={this.handleSubmit}>
                <input type="text" placeholder="Usuario..." name="usuario" value={this.state.usuario} onChange={this.handleChange}/><br/>
                <input type="password" placeholder="Contraseña..." name="contrasenya" value={this.state.contrasenya} onChange={this.handleChange}/><br/>
                <input type="submit" value="Iniciar Sesión"/>
            </form>
            <div style={{
                    display: (
                        this.state.login
                        ? 'inline'
                        : 'none')
                }}>This is visible</div>
        </div>);
    }
}

export default LoginForm;