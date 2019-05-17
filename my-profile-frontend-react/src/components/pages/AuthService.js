class AuthService {
    constructor() {
        if (!!AuthService.instance) {
            console.log('No need to create new object')
            return AuthService.instance;
        }
        console.log('Create new object')
        AuthService.instance = this;

        this.username = '';
        this.password = '';

        return this;
    }

    setUsername(usname) {
        return this.username = usname;
    }

    setPassword(psword) {
        return this.password = psword;
    }

    isLoggedIn() {
        if (this.username == "test" && this.password == "test") {
            console.log('yyyyyyyy')
            return true;
        }
        console.log('xxxxxxxxxx')
        console.log(this.username)
        console.log(this.password)
        console.log('xxxxxxxxxx')
        return false;
    }
}

export default AuthService;